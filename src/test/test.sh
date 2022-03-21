#!/usr/bin/env bash
kubectl scale deployment/k8s-seemless-deployment --replicas=4
ab -c 2 -n 100000 http://localhost:30007/
