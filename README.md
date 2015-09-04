Simple Maven plugin aims to remove Byte Order Mark (BOM) from text files.
Based upon [this project](hhtp://github.com/s1ac2x1/bom-remover)

###### Usage

Add to your's pom.xml a link to plugin's repository:

```xml
<pluginRepositories>
  <pluginRepository>
    <id>kishlaly</id>
    <url>http://maven.kishlaly.com</url>
    <layout>default</layout>
  </pluginRepository>
</pluginRepositories>
```
now you can declare the plugin:

```xml
<plugins>
  <plugin>
    <groupId>com.kishlaly.utils.maven</groupId>
    <artifactId>bom-remover</artifactId>
    <version>1.0</version>
    <configuration>
      <folder>${path.to.folder.with.bom.files}</folder>
      <mask>*</mask>
      <type>default</type>
      <deep>y</deep>
    </configuration>
    <executions>
      <execution>
        <phase>package</phase>
        <goals>
          <goal>work</goal>
        </goals>
      </execution>
    </executions>
  </plugin>
</plugins>
```

1. **folder** - where to find files to work with, "." if not set
2. **mask** - by default set to "*"
3. **type** - the only one possible type is *default*
4. **deep** - whether to look into subfolders, "y" or "n", "y" if not set
