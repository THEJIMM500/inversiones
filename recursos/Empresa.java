package inversiones;

public class Empresa {
	
	private enum nombreEmpresa{amazon, apple, google, microsoft, facebook, imdb, twitch, git, paypal};
	private nombreEmpresa empresa;
	private String[] lista = {"amazon", "apple", "google", "microsoft", "facebook", "imdb", "twitch", "git", "paypal"};
	
	public Empresa(String nombre) {
		for (int i = 0; i < lista.length; i++) {
			if (nombre.equals(lista[i])) {
				String leeLista = lista[i];
				empresa = nombreEmpresa.valueOf(leeLista);
			}
		}
	}
	
	public nombreEmpresa getNombreEmpresa() {
		return empresa;
	}

}
