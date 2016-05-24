# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  # A standard Ubuntu 12.04 LTS 32-bit box
  # For more boxes, you can look at https://atlas.hashicorp.com/boxes/search
  config.vm.box = "hashicorp/precise32"
  config.vm.provision "shell", path: "vagrant_provision.sh"
  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  config.vm.network "private_network", ip: "192.168.33.10"
end
