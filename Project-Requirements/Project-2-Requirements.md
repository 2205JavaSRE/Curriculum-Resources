# Project 2 requirements

## Description (Due: 06/24/2022)

Project 2 will be a group project focusing on the deployment and monitoring of an application. Each group will be comprised of 4 team members. Each group will select one of the team members P0 build off of (refactor into a REST-based API).

The goal is to introduce working in a group and researching SRE principles.

## Methodology

Each group should follow an Agile approach and implement the SCRUM methodology.
- Each team will designate a team leader and decide on a team name 
- Each team will choose a project from one of their member's Project 0's.
- Each team should track the tasks being worked on a kanban board
- Each team will create a folder in a common repository and store their stand-up notes there

## Requirements

Teams are allowed to create a new namespace on our common AWS cluster for project 2, the application should be deployed in the new namespace.

1. Each team must define SLO for their application. (resources: https://sre.google/sre-book/service-level-objectives/, https://sre.google/workbook/implementing-slos/)
    - Must include error rates as well as latencies
    - Must include their custom metrics
2. Each team must configure Prometheus to retrieve metrics from the deployed application
    - teams must create at least 1 custom metrics through the micrometer API
        - Should be incorporated into the SLOs, should indicate something about the quality of the application
3. Each team must define alerting rules based on their SLO
4. Each team must create at least 1 Grafana dashboard with multiple panels to track all of the metrics associated with their SLO
    - Examples could be tracking cpu/memory usage from Prometheus
    - The idea is to have visualizations that might indicate that a problem might occur soon, even if an alert has not fired yet
5. Each team must have a full DevOps pipeline built using Jenkins
    - This pipeline must be configured through a Jenkinsfile and triggered in response to a webhook
    - The project will be deployed with a canary deployment model
6. Each team must utilize Terraform to provision resources to be able to deploy Jenkins on a stand alone server, seperate to the K8 cluster (i.e. on an EC2 instance) 