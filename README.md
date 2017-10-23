[TOC]

# Java-Gradle-Probe

# ENV

Project Runtime:

|title|description|
|-----|-----------|
|jdk|1.8.+|
|gradle|3.3|
|eu.appsatori:gradle-fatjar-plugin|0.3|


# Last Version Info

- In Base Dev, not has release! see [Build]

- version 0.0.1
- repo at
- change [TAG.md](TAG.md)

provides :

- Use see [Doc](Doc/preface.md)
- ~~Full method count 00~~

# Build

- check env
- get code

## jvmProbe

```sh
./gradlew :jvmProbe:runOutLibs
```

out jar at `./build/outLibs/jvmProbe-*.jar`

- use

```sh
cd ./build/outLibs
java -jar [params] jvmProbe-*.jar -h
```

# test

### License

<pre>
Copyright sinlovgmppt@gmail.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
