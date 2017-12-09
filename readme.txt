公司后台框架
1.基于maven构建
2.后台交互改成rest接口
3.公司的maven仓库地址:http://58.210.98.62:7080/nexus/index.html#welcome
4.注意pom.xml文件中仓库地址和插件仓库地址的配置


<!-- 公司内部 -->
<!-- jar依赖库 -->
 <repositories>
		<repository>
			<id>gaeainfoMavenCode</id>
			<url>http://58.210.98.62:7080/nexus/content/groups/public/</url>
		</repository>
</repositories>

<!-- 插件库 -->
 <pluginRepositories>
      <pluginRepository>
               <id>gaeainfoMavenPlugin</id>
               <url>http://58.210.98.62:7080/nexus/content/groups/public/</url>   
        </pluginRepository>
   </pluginRepositories>


注意：动态图层部分，需要继承DefaultDynamicDataAdapter 重写方法：executeForQueryDB(...),代码示例如下：

            if (!ot.getChildren().isEmpty()) continue;
            DefaultDicTable table = manager.getTableByObjectTypeId(ot.getPid());


            String sql = "select * from " + table.getTableName();
            List<Map<String, Object>> list = this.getListBySql(sql);
            for (Map<String, Object> map : list) {
                String id = GaeaCommonUtil.trimToEmpty(map.get("pid"));
                String name = GaeaCommonUtil.trimToEmpty(map.get("name"));
                double x = GaeaCommonUtil.parseToDouble(map.get("x"), 0);
                double y = GaeaCommonUtil.parseToDouble(map.get("y"), 0);
                String coord = "";
                DefaultDynamicFeature ft = new DefaultDynamicFeature(id, ot.getCode(), name, "");
                ft.setLng(GaeaCommonUtil.parseToDouble(x, 0));
                ft.setLat(GaeaCommonUtil.parseToDouble(y, 0));
                ft.setCoord(GaeaCommonUtil.trimToEmpty(coord));

                result.put(id, ft);
            }


使用图层树时，必须配置system.properties属性文件