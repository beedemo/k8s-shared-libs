#!/usr/bin/groovy

def call(String name, Closure body) {
  podTemplate(label: 'kubernetes',
    containers: [containerTemplate(name: "name", image: "$imageName:$imageTag", command: 'cat', ttyEnabled: true)]) {
    node('kubernetes') {
      container("name") {
        body()
      }
    }
  }
}
