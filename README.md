Simple Maven plugin aims to remove Byte Order Mark (BOM) from text files.
Based upon [this project](http://github.com/s1ac2x1/bom-remover).

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
        <phase>validate</phase>
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

Please pay attention to phase in which you'll plan to use that plugin. It is quite useless to update files after packaging, so if you want to assemble application with corrected files, use plugin in phases prior to *package*
