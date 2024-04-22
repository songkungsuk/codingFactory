import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class VOGenerator {
    public static String generateVOClass(String schema) {
        Map<String, ColumnInfo> columnMap = parseSchema(schema);
        return generateClassDefinition(columnMap);
    }

    private static Map<String, ColumnInfo> parseSchema(String schema) {
        Map<String, ColumnInfo> columnMap = Arrays.stream(schema.split("\n"))
            .map(line -> line.split(";"))
            .collect(Collectors.toMap(
                VOGenerator::convertSnakeCaseToCamelCase,
                line -> ColumnInfo.builder()
                    .name(line[0])
                    .dataType(line[1])
                    .comment(line[2])
                    .build()));
        return columnMap;
    }

    private static String convertSnakeCaseToCamelCase(String[] parts) {
        StringBuilder camelCase = new StringBuilder(parts[0].toLowerCase());
        for (int i = 1; i < parts.length; i++) {
            camelCase.append(capitalize(parts[i]));
        }
        return camelCase.toString();
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String generateClassDefinition(Map<String, ColumnInfo> columnMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("import lombok.Builder;\n");
        sb.append("import lombok.Getter;\n");
        sb.append("import lombok.Setter;\n");
        sb.append("import lombok.ToString;\n\n");
        sb.append("@Getter\n");
        sb.append("@Setter\n");
        sb.append("@ToString\n");
        sb.append("@Builder\n");
        sb.append("public class VO {\n");

        for (ColumnInfo column : columnMap.values()) {
            sb.append("    private ").append(getJavaType(column.getDataType())).append(" ").append(convertToCamelCase(column.getName())).append(";\n");
        }

        sb.append("}");
        return sb.toString();
    }

    private static String getJavaType(String dataType) {
        Map<String, String> typeMap = new LinkedHashMap<>();
        typeMap.put("bigint", "Long");
        typeMap.put("varchar", "String");
        typeMap.put("int", "Integer");
        typeMap.put("datetime", "String");

        return typeMap.getOrDefault(dataType, "Object");
    }

    public static String convertToCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        String[] parts = input.split("_");

        for (int i = 0; i < parts.length; i++) {
            if (i == 0) {
                sb.append(parts[i].toLowerCase());
            } else {
                sb.append(capitalize2(parts[i]));
            }
        }

        return sb.toString();
    }

    private static String capitalize2(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Getter
    @Setter
    @ToString
    @Builder
    private static class ColumnInfo {
        private String name;
        private String dataType;
        private String comment;
    }

    public static void main(String[] args) {
        String schema =
             "SCRAP_PK;bigint;스크랩 테이블 PK\n"
            + "REG_DTM;datetime;등록일\n"
            + "REG_EMP_ID;varchar;등록 아이디\n"
            + "UPD_DTM;datetime;수정일\n"
            + "UPD_EMP_ID;varchar;수정 아이디\n"
            + "SCRAP_AT;varchar;스크랩 여부\n"
            + "BOARD_PK;bigint;게시글PK\n";
        String voClassDefinition = VOGenerator.generateVOClass(schema);
        System.out.println(voClassDefinition);
    }
}