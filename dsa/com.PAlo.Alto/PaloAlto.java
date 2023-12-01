import java.util.*;

public class PaloAlto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pro = sc.nextLine().split("\\s");

        int numDep = sc.nextInt();
        List<String[]> depList = new ArrayList<>();

        for (int i = 0; i < numDep; i++) {
            String pro1 = sc.next();
            String pro2 = sc.next();
            depList.add(new String[]{pro1, pro2});
        }

        List<String> buildOrder = findBuildOrder(pro, depList);

        if (buildOrder != null) {
            System.out.println("Build Order: " + buildOrder);
        } else {
            System.out.println("No valid build order exists. Circular dependency detected.");
        }
    }

    private static List<String> findBuildOrder(String[] pro, List<String[]> depList) {
        HashMap<String, List<String>> dependencies = new HashMap<>();
        for (String[] dependency : depList) {
            String pro1 = dependency[0];
            String pro2 = dependency[1];

            if (!dependencies.containsKey(pro1)) {
                dependencies.put(pro1, new ArrayList<>());
            }

            dependencies.get(pro1).add(pro2);
        }

        List<String> buildOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String project : pro) {
            if (!visited.contains(project)) {
                if (!dfs(project, dependencies, visited, buildOrder, new HashSet<>())) {
                    return null; 
                }
            }
        }

        Collections.reverse(buildOrder);
        return buildOrder;
    }

    private static boolean dfs(String project, HashMap<String, List<String>> dependencies,
                                Set<String> visited, List<String> buildOrder, Set<String> visiting) {
        if (visiting.contains(project)) {
            return false; 
        }

        if (!visited.contains(project)) {
            visiting.add(project);

            if (dependencies.containsKey(project)) {
                for (String dependency : dependencies.get(project)) {
                    if (!dfs(dependency, dependencies, visited, buildOrder, visiting)) {
                        return false;
                    }
                }
            }

            visiting.remove(project);
            visited.add(project);
            buildOrder.add(project);
        }

        return true;
    }
}
