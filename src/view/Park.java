package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCar;

public class Park {

	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int idCar = 0 ; idCar < 10 ; idCar++){
			Thread t = new ThreadCar(idCar, semaforo);
			t.start();
		}
	}

}
