#This is a comment on the terraform file. 
#Any terraform file can be created with a .tf extension 

#The purpose of Terraform is to automate the process of provisioning resources. 
#Rather than manually configuring the resources (e.g. db or ec2, or s3)
#Create scripts with Terraform and provsion the resource with a single cli command.
#Terraform is "declarative" - we define a final state we don't care "how" Terraform does it.  

#Big advantage of Terraform is that it is platform (provider) indpendent 

#Installing Terraform: 
# Download and export Terraform zipped folder
# Store the terraform executable anywhere, as long as you can find it (know the path)
# Add the exe to the PATH of the system variable 
# Check if its running by running $ terraform 

# Terraform CLI: 
#     To create a Terraform file, we can create a file with a .tf 
#     To start "executing" terraform stuff, we need to initialize an environment where the terraform file is: 
#     (the .tf does not need to be in the same folder as the executable)    
#     (the .tf must contain a provider, e.g. AWS, GCP, ... etc )
#         $terraform init 

#     We can check to see what our terraform file will do by:
#         $terraform plan 

#     We can execute it: 
#         $terraform apply 
#         $terraform apply --auto-approve 

#     We can destroy resources that we created by either commenting out or removing the 
#     resource declaration and rexecuting the file or we can execute: 
#         $terraform destroy

# terraform.tfstate: will keep track of all the resources it creates, so it knows what to modify, create or delete. 
#                     IT IS VERY IMPORTANT that you don't change or delete anything. 

#----------------------------------------------------------------------------------------------

#1) Configure the AWS provider so that terraform has access!
#
#provider "<provider, e.g. AWS, GCP>" {
#     key=value
#     access_key= 
#     secret_key=
# }

provider "aws" {
  region = "us-east-1"
  access_key=""
  secret_key = ""
}


#2) Provision resources!

# resource "<provider>_<resource_type>" "<name>"{
#     config options... 
#     key = "value"
#     key2 = "another value of stuff"
# }

#Setting up security group 
resource "aws_security_group" "allow_db_access_terra" {
  name = "allow access"
  description = "allow access to db and ec2"

#Defining inbound rules for our services
  ingress {
      from_port = 5431
      to_port = 5433
      protocol = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
      ipv6_cidr_blocks = ["::/0"]
  }

#Egress rules are for defining outbound rules!
  egress {
      from_port = 0 
      to_port = 0 
      protocol = "-1"
      cidr_blocks = ["0.0.0.0/0"]
      ipv6_cidr_blocks = ["::/0"]
  }


}

resource "aws_security_group" "terra_ec2_access" {
  name = "allow access to ec2"
  description = "allow access to db and ec2"

#Defining inbound rules for our services
  ingress {
      from_port = 7000
      to_port = 8000
      protocol = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
      ipv6_cidr_blocks = ["::/0"]
  }

  ingress {
      from_port = 22
      to_port = 22
      protocol = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
      ipv6_cidr_blocks = ["::/0"]
  }

#Egress rules are for defining outbound rules!
  egress {
      from_port = 0 
      to_port = 0 
      protocol = "-1"
      cidr_blocks = ["0.0.0.0/0"]
      ipv6_cidr_blocks = ["::/0"]
  }


}

#Provisiong a RDS database 
# resource "aws_db_instance" "terraform_db_instance" {
#     allocated_storage = 20
#     engine = "postgres"
#     engine_version = "14.1"
#     instance_class = "db.t3.micro"
#     username = "postgres"
#     password = "password"
#     skip_final_snapshot = true
#     publicly_accessible = true

# #Associate "allow_db_access" to our db instance. 
#     vpc_security_group_ids = [aws_security_group.allow_db_access_terra.id ]

#     tags = {
#       name = "terraform db"
#       purpose = "demo"
#       owner = "ben"
#     }
# }

#Provisioning a EC2 instance 
resource "aws_instance" "terraform_web_server" {
    
    ami = "ami-0022f774911c1d690"
    instance_type = "t2.micro"
    availability_zone = "us-east-1a"
    key_name = "2205Key"

    vpc_security_group_ids = [aws_security_group.terra_ec2_access.id]

    user_data = <<-EOF
                #!/bin/bash
                sudo yum update -y 
                sudo yum install git -y
                sudo yum install java-1.8.0-devel -y 
                EOF

    tags = {
      "name" = "terraform server"
    }
}