package DSA.Arrays.Strings;


import java.util.List;

/*
[{"id":1,"name":"Gregory Gwilliam","manager_id":2},{"id":2,"name":"Brice Martin","manager_id":null}]
*/
class JsonConvert {


    public static void main(String[] args) {

        List<List<String>> input = List.of(
                List.of("1", "Gregory Gwilliam", "2"),
                List.of("2", "Brice Martin"),
                List.of("2", "Brice 2", "")
        );

        System.out.println(getJson(input));
    }

    public static String getJson(List<List<String>> lines) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<String> line : lines) {
            sb.append("{");
            sb.append("\"id\"");
            sb.append(":");
            sb.append(Integer.parseInt(line.get(0)));
            sb.append(",");
            sb.append("\"name\"");
            sb.append(":");
            sb.append(line.get(1));
            sb.append(",");
            sb.append("\"manager_id\"");
            sb.append(":");
            if (line.size() > 2) {
                if (line.get(2).isEmpty()) {
                    sb.append("null");
                } else {
                    sb.append(Integer.parseInt(line.get(2)));
                }
            } else {
                sb.append("null");
            }

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
