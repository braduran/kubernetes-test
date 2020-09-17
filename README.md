# Paso a paso para ejecutar kubernetes local

## Crear imagen con Dockerfile
docker build  -t "carga-test" .

## Inicia minikube
minikube start

## Ejecutar docker local en minikube
eval $(minikube docker-env) 

## Exponer host con el que se consumira el servicio
export INGRESS_HOST=$(minikube ip) 

## Exponer puerto con el que se consumira el servicio
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}') 

## Url del gateway host y puerto
export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT 

## Habilitar metrics-server
minikube addons enable metrics-server

## Crear namespace
kubectl create namespace <namespace name>

## Ejecutar app.yaml
kubectl apply -f app.yaml

## Ejecutar gateway.yaml
kubectl apply -f gateway.yaml

# Bonus

## Ver graficamente toda la información del cluster
minikube dashboard