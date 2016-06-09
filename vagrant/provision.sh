#!/usr/bin/env bash

debconf-set-selections <<< 'mysql-server mysql-server/root_password password test'
debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password test'

sudo apt-get update
echo "Installing Apache.."
sudo apt-get install -y apache2
echo "Installing Mysql.."
sudo apt-get install -y mysql-server
echo "Installing Tomcat.."
sudo apt-get install -y tomcat7
echo "Installing Tomcat7 administration webapps.."
sudo apt-get install -y tomcat7-admin
echo "Installing Git.."
sudo apt-get install -y git
echo "Installing Maven.."
sudo apt-get install -y maven
echo "Installing Java 7.."
sudo apt-get install -y software-properties-common python-software-properties
echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo add-apt-repository ppa:webupd8team/java -y
sudo apt-get update
sudo apt-get install oracle-java7-installer
echo "Setting environment variables for Java 7.."
sudo apt-get install -y oracle-java7-set-default

echo "Creating project database.."
service apache2 stop
mysql -uroot -ptest < /vagrant/vagrant/database/db_changes.sql
service apache2 start

# file permission for logging, timezone
sudo chmod -R 777 /vagrant/vagrant/
mkdir ~/logs
timedatectl set-timezone Europe/Warsaw

cd /vagrant
sudo mvn clean install

echo "Linking project WAR to tomcat deploy directory"
sudo rm -rf /var/lib/tomcat7/webapps/ROOT
sudo ln -fs /vagrant/client/target/client/ /var/lib/tomcat7/webapps/ROOT
sudo rm -rf /var/lib/tomcat7/webapps/ROOT/WEB-INF/classes
sudo ln -fs /vagrant/server/target/classes/ /var/lib/tomcat7/webapps/ROOT/WEB-INF/classes

cd /etc/default
sudo su
echo "JAVA_HOME=/usr/lib/jvm/java-7-oracle" >> tomcat7

service tomcat7 restart
echo "Project can be run from URL http://192.168.33.10:8080"

