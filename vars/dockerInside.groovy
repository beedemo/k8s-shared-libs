#!/usr/bin/groovy

def call(image) {
  podTemplate(label: kubernetes,
    containers: [containerTemplate(name: "$image", image: "$image", command: 'cat', ttyEnabled: true)]) {
    container("$image") {
      body()
    }
  }
}
