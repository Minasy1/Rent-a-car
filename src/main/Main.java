package main;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import controller.Init;
import controller.KorisnickiInput;
import model.Bicikl;
import model.Gorivo;
import model.Iznajmljivac;
import model.Osoba;
import model.PutnickoVozilo;
import model.Rezervacija;
import model.Servis;
import model.Sluzbenik;
import model.TeretnaVozila;

import model.Vozilo;

import view.Meni;

public class Main implements KorisnickiInput {

	// Metoda za start aplikacije
	public void start(Osoba o) {
		if (Init.uloga(o)) {
			Meni.izborMeniSluzbenik(o);
		} else {
			Meni.izborMeniIznajmljivac(o);
		}
	}

	// Liste
	public static ArrayList<Osoba> osobeAll = new ArrayList<Osoba>();
	public static ArrayList<Vozilo> vozilaAll = new ArrayList<Vozilo>();
	public static ArrayList<Servis> servisAll = new ArrayList<Servis>();
	public static ArrayList<Gorivo> gorivaAll = new ArrayList<Gorivo>();
	public static ArrayList<Rezervacija> rezervacijeAll = new ArrayList<Rezervacija>();

	// getteri i setteri
	public static ArrayList<Osoba> getOsobeAll() {
		return osobeAll;
	}

	public static void setOsobeAll(ArrayList<Osoba> osobeAll) {
		Main.osobeAll = osobeAll;
	}

	public static ArrayList<Vozilo> getVozilaAll() {
		return vozilaAll;
	}

	public static void setVozilaAll(ArrayList<Vozilo> vozilaAll) {
		Main.vozilaAll = vozilaAll;
	}

	public static ArrayList<Servis> getServisAll() {
		return servisAll;
	}

	public static void setServisAll(ArrayList<Servis> servisAll) {
		Main.servisAll = servisAll;
	}

	public static ArrayList<Gorivo> getGorivaAll() {
		return gorivaAll;
	}

	public static void setGorivaAll(ArrayList<Gorivo> gorivaAll) {
		Main.gorivaAll = gorivaAll;
	}

	public static ArrayList<Rezervacija> getRezervacijeAll() {
		return rezervacijeAll;
	}

	public static void setRezervacijeAll(ArrayList<Rezervacija> rezervacijeAll) {
		Main.rezervacijeAll = rezervacijeAll;
	}

	// -----------------------
	public static Gorivo benzin = new Gorivo("Benzin", 140.5);
	public static Gorivo dizel = new Gorivo("Dizel", 148.0);
	public static Gorivo elektricnaEnergija = new Gorivo("Elektricna Energija",40);
	public static Gorivo nista = new Gorivo("Nema gorivo",0);
	//--------------------------------------------------
	public static Sluzbenik o1 = new Sluzbenik("ime1", "lozinka1", "34532", "Marko", "Maki", "Sluzbenik");
	public static Iznajmljivac o2 = new Iznajmljivac("ime2", "lozinka2", "blablajmbg", "Filip", "fica", "Iznajmljivac",
			"06333222", "Srbija");
	//----------------------------------------------------------
	public static PutnickoVozilo a1 = new PutnickoVozilo("Putnicko Vozilo", "2425", new ArrayList<Gorivo>(), 3, 6.1d, 160000, 5000, 10000,
			2500, 4, 4, false, new ArrayList<Servis>());
	public static PutnickoVozilo a12 = new PutnickoVozilo("Putnicko Vozilo", "2211", new ArrayList<Gorivo>(), 1, 7.8, 10000, 15000,3000,1500,4,4,false, new ArrayList<Servis>());
	//--------------------------------------------------------------
	public static TeretnaVozila a2 = new TeretnaVozila("Teretno Vozilo", "5253", new ArrayList<Gorivo>(), 4, 7.0d, 200000, 3000, 12000,
			3200, 4, 4, false, new ArrayList<Servis>(), 2225, 2.2d);
	public static TeretnaVozila a21 = new TeretnaVozila("Teretno Vozilo","9098", new ArrayList<Gorivo>(),1, 10, 120000,25000, 6000, 2000, 2, 3,false,new ArrayList<Servis>(), 5000,2);
	//----------------------------------------------------------------------
	public static Bicikl a3 = new Bicikl("Bicikl", "6576", new ArrayList<Gorivo>(), 2, 0.0d, 1500, 100, 1500, 500, 1, 0, false,
			new ArrayList<Servis>());
	public static Bicikl a4 = new Bicikl("Bicikl", "6666", new ArrayList<Gorivo>(), 3, 0.0d, 1200, 250, 1500, 600, 1, 0, false,
			new ArrayList<Servis>());
	//--------------------------------------------------------------------------------------
	public static Servis e1 = new Servis(a1, "15/07/2017", 150000);
	public static Servis e2 = new Servis(a2, "13/05/2016", 120000);
	public static Servis e3 = new Servis(a3, "10/10/2015", 1399);
	public static Servis e4 = new Servis(a12,"12/10/2016", 0);
	public static Servis e5 = new Servis(a21,"12/12/2016",115000);
	public static Servis e6 = new Servis(a4, "05/06/2017",1000);
	//-------------------------------------------------------------------------
	public static Rezervacija r2 = new Rezervacija(a21,o2,10000, false, "10/05/2016","15/05/2016");
	public static Rezervacija r1 = new Rezervacija(a1, o2, 15000d, false, "10/10/2015", "20/10/2015");
	//-------------------------------------------------------------
	public static void popuni() {
		gorivaAll.add(dizel);
		gorivaAll.add(benzin);
		gorivaAll.add(elektricnaEnergija);
		osobeAll.add(o1);
		osobeAll.add(o2);
		vozilaAll.add(a1);
		vozilaAll.add(a2);
		vozilaAll.add(a3);
		vozilaAll.add(a4);
		vozilaAll.add(a12);
		vozilaAll.add(a21);
		servisAll.add(e1);
		servisAll.add(e2);
		servisAll.add(e3);
		servisAll.add(e4);
		servisAll.add(e5);
		servisAll.add(e6);
		rezervacijeAll.add(r1);
		rezervacijeAll.add(r2);
		a1.dodajServis(e1);
		a2.dodajServis(e2);
		a3.dodajServis(e3);
		a4.dodajServis(e6);
		a12.dodajServis(e4);
		a21.dodajServis(e5);
		a1.dodajGorivo(benzin);
		a12.dodajGorivo(dizel);
		a12.dodajGorivo(elektricnaEnergija);
		a2.dodajGorivo(dizel);
		a21.dodajGorivo(dizel);
		a3.dodajGorivo(nista);
		a4.dodajGorivo(nista);
		

	}
	// Main
	public static void main(String[] args) throws JsonParseException, JsonMappingException {
		// pokretanje aplikacije
		popuni();
		System.out.println("----------------------------");
		System.out.println("Ulogovanje kao sluzbenik:");
		System.out.println("Korisnicko ime: ime1");
		System.out.println("Lozinka: lozinka1\n");
		System.out.println("----------------------------");
		System.out.println("Ulogovanje kao iznajmljivac:");
		System.out.println("Korisnicko ime: ime2");
		System.out.println("Lozinka: lozinka2\n");
		System.out.println("----------------------------");

		Main app = new Main();
		app.start(Init.Login());
	}
}
