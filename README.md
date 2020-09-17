### Paso a paso para ejecutar kubernetes local

1. Crear imagen con Dockerfile
```console
docker build  -t "carga-test" . 
```

2. Inicia minikube
```console
minikube start
```

3. Ejecutar docker local en minikube
```console
eval $(minikube docker-env)
```

4. Exponer host con el que se consumira el servicio
```console
export INGRESS_HOST=$(minikube ip)
``` 

5. Exponer puerto con el que se consumira el servicio
```console
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')
```

6. Url del gateway host y puerto
```console
export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT
```

7. Habilitar metrics-server
```console
minikube addons enable metrics-server
```

8. Crear namespace
```console
kubectl create namespace <namespace name>
```

9. Ejecutar app.yaml
```console
kubectl apply -f app.yaml
```

10. Ejecutar gateway.yaml
```console
kubectl apply -f gateway.yaml
```

### Bonus

* Ver graficamente toda la información del cluster
```console
minikube dashboard
```