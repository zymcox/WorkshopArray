package se.lexicon;

public class NameRepository {

    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void setNames(String[] newNames) {
        names = newNames.clone();
    }

    public static void clear() {
        names = new String[0];
    }

    public static String[] findAll() {
        return names.clone();
    }

    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }

    public static boolean add(final String fullName) {
        if (find(fullName) != null) {
            return false;
        }
        String[] newNames = new String[names.length + 1];
        System.arraycopy(names, 0, newNames, 0, names.length);
        newNames[names.length] = fullName;
        names = newNames;
        return true;
    }

    public static String[] findByFirstName(final String firstName) {
        return java.util.Arrays.stream(names)
                .filter(name -> name.split(" ")[0].equals(firstName))
                .toArray(String[]::new);
    }

    public static String[] findByLastName(final String lastName) {
        return java.util.Arrays.stream(names)
                .filter(name -> name.split(" ")[1].equals(lastName))
                .toArray(String[]::new);
    }

    public static boolean update(final String original, final String updatedName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                if (find(updatedName) == null) {
                    names[i] = updatedName;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean remove(final String fullName) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        String[] newNames = new String[names.length - 1];
        System.arraycopy(names, 0, newNames, 0, index);
        System.arraycopy(names, index + 1, newNames, index, names.length - index - 1);
        names = newNames;
        return true;
    }
}


