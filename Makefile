build:
	go build run.go && mv run go-run
	scala-cli package run.scala --native --native-mode release-fast -f -o ./scala-native-run
	scala-cli package run-optimised.scala --native --native-mode release-fast -f -o ./scala-native-optimised-run
	clang run.c -O1 -o c-run

# Had to exclude python because where others finish before 3 seconds, it takes 2 minutes on my machine..
# not sure why
benchmark:
	hyperfine --warmup 10 './scala-native-run 10' './scala-native-optimised-run 10' './go-run 10' './c-run 10' 'node run.js 10' # 'python3 run.py 10'
