# gitbucket-3dmol-plugin

[![Build Status](https://travis-ci.org/onukura/gitbucket-3dmol-plugin.svg?branch=master)](https://travis-ci.org/onukura/gitbucket-3dmol-plugin)
![Scala CI](https://github.com/onukura/gitbucket-3dmol-plugin/workflows/Scala%20CI/badge.svg?branch=master)

A GitBucket plugin for rendering molecular.  
Based on [3DMol.js](https://3dmol.csb.pitt.edu/index.html).

## Screenshot

![screenshot](https://github.com/onukura/gitbucket-3dmol-plugin/blob/assets/screenshot.gif?raw=true)

## Build from source

```sbt
sbt clean package
```

The built package is located at
`target/scala-2.13/gitbucket-3dmol-plugin_2.13-{plugin-version}.jar`.

```sbt
sbt assembly
```

This makes the assembly package
`target/scala-2.13/gitbucket-3dmol-plugin-{plugin-version}.jar`
for deployment.

## Reference

Nicholas Rego, David Koes, 3Dmol.js: molecular visualization with WebGL, Bioinformatics, Volume 31, Issue 8, 15 April 2015, Pages 1322–1324, https://doi.org/10.1093/bioinformatics/btu829
