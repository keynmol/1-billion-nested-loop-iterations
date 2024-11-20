build:
	go build run.go && mv run go-run
	scala-cli package run.scala --native --native-mode release-fast -f -o ./scala-native-run
	clang run.c -O1 -o c-run

benchmark:
	hyperfine './scala-native-run 10' './go-run 10' './c-run 10' 'node run.js 10' 'python3 run.py 10'
