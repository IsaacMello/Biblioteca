package Usuario;

public class GerarID {
	
	private static int ID = 1;

    public static int getProximaMatricula() {
        return ID++;
    }
}