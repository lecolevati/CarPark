package controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {

	private int idCar;
	private Semaphore semaforo;
	private static int posicaoChegada;
	private static int posicaoSaida;

	public ThreadCar(int idCar, Semaphore semaforo) {
		this.idCar = idCar;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroParado();
			carroSaindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carroAndando() {
		int distanciaFinal = (int) ((Math.random() * 2001) + 1000);
		int distanciaPercorrida = 0;
		int velocidade = (int) ((Math.random() * 6) + 10);
		while (distanciaFinal > distanciaPercorrida) {
			distanciaPercorrida = distanciaPercorrida + velocidade;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			System.out.println("O Carro #" + idCar + " percorreu "
//					+ distanciaPercorrida + " km");
		}
		posicaoChegada++;
		System.out.println("O Carro #" + idCar + " foi o "+posicaoChegada+"o. a chegar");
	}

	private void carroParado() {
		System.out.println("O Carro #" + idCar + " estacionou");
		int tempo = (int) ((Math.random() * 501) + 2500);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		posicaoSaida++;
		System.out.println("O Carro #" + idCar + " foi o "+posicaoSaida+"o. a sair");
	}

}
