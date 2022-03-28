#!/usr/bin/env bash
kubectl scale deployment/k8s-seamless-deployment --replicas=2
ab -c 2 -n 100000 http://localhost:30007/
# as a comparison, try
# ab -c 2 -n 100000 http://localhost:8080/
