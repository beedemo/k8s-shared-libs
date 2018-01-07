#!/usr/bin/groovy

def call(String image, Closure body) {
  podTemplate(label: kubernetes,
    containers: [containerTemplate(name: "$image", image: "$image", command: 'cat', ttyEnabled: true)]) {
    container("$image") {
      body()
    }
  }
}
