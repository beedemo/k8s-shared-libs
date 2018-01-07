#!/usr/bin/groovy

def call(String image, Closure body) {
  podTemplate(label: 'kubernetes',
    containers: [containerTemplate(name: "name", image: "$image", command: 'cat', ttyEnabled: true)]) {
    node('kubernetes') {
      container("name") {
        body()
      }
    }
  }
}
