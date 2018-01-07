#!/usr/bin/groovy

def call(String imageName, String imageTag, Closure body) {
  podTemplate(label: 'kubernetes',
    containers: [containerTemplate(name: "$imageName", image: "$imageName:$imageTag", command: 'cat', ttyEnabled: true)]) {
    node('kubernetes') {
      container("$imageName") {
        body()
      }
    }
  }
}
