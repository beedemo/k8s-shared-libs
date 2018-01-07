#!/usr/bin/groovy

def call(String image, Closure body) {
  def name = sh (returnStdout: true, script: "echo '${image}' |sed 's/:.*//'")
  podTemplate(label: 'kubernetes',
    containers: [containerTemplate(name: "$name", image: "$image", command: 'cat', ttyEnabled: true)]) {
    node('kubernetes') {
      container("$name") {
        body()
      }
    }
  }
}
