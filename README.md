# ThemeParkRide

Generate a helm chart and docker image - run command: 
mvn clean install k8s:build k8s:resource k8s:apply k8s:helm  


k8s:build - builds a docker image
k8s:resource - Generate Kubernetes Manifests
k8s:apply - Apply generated Kubernetes Manifests onto Kubernetes
k8s:helm - creates a helm chart
