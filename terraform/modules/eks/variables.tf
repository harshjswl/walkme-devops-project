variable "cluster_name" {
  type = string
}

variable "public_subnet_ids" {
  description = "Public subnet IDs for EKS"
  type        = list(string)
}

variable "private_subnet_ids" {
  description = "Private subnet IDs for EKS node group"
  type        = list(string)
}

variable "kubernetes_version" {
  type    = string
  default = "1.29"
}
