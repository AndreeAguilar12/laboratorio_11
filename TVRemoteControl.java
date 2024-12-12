package LP;
interface Command {
void execute();
}
class ComandoEncender implements Command {
	private Television television;
	public ComandoEncender(Television television) {
    	this.television = television;
	}
	@Override
	public void execute() {
		television.encender();
	}
}
class ComandoApagar implements Command {
	private Television television;
	public ComandoApagar(Television television) {
    	this.television = television;
	}
	@Override
	public void execute() {
    	television.apagar();
	}
}
class ComandoSubirVolumen implements Command {
	private Television television;
	public ComandoSubirVolumen(Television television) {
    	this.television = television;
	}
	@Override
	public void execute() {
    	television.subirvolumen();
	}
}
class ComandoBajarVolumen implements Command {
	private Television television;
	public ComandoBajarVolumen(Television television) {
	 	this.television = television;
	}
	@Override
	public void execute() {
    	television.bajarvolumen();
	}
}
class ComandoCambiarCanal implements Command {
	private Television television;
	private int canal;
	public ComandoCambiarCanal(Television television, int canal) {
    	this.television = television;
    	this.canal = canal;
	}
	@Override
	public void execute() {
    	television.CambiarCanal(canal);
	}
}
class Television {
	public void encender() {
    	System.out.println("Television encendida.");
	}
	public void apagar() {
    System.out.println("Television apagada.");
	}
	public void subirvolumen() {
	 	System.out.println("Volumen aumentado.");
	}
	public void bajarvolumen() {
	 	System.out.println("Volumen disminuido.");
	}
	public void CambiarCanal(int canal) {
	 	System.out.println("Canal cambiado a "+canal);
	}
}
class ControRemoto {
private Command command;
public void setCommand(Command command) {
    this.command = command;
}
public void pressButton() {
    command.execute();
}
}
public class ControlRemoto {
public static void main(String[] args) {
    Television tv = new Television();
   
    Command encender = new ComandoEncender(tv);
    Command apagar = new ComandoApagar(tv);
    Command subirvolumen = new ComandoSubirVolumen(tv);
    Command bajarvolumen = new ComandoBajarVolumen(tv);
    Command CambiarCanal = new ComandoCambiarCanal(tv, 5);
   
    ControRemoto control = new ControRemoto();
    control.setCommand(encender);
    control.pressButton();
    control.setCommand(subirvolumen);
    control.pressButton();
   
    control.setCommand(CambiarCanal);
    control.pressButton();
    control.setCommand(bajarvolumen);
    control.pressButton();
    control.setCommand(apagar);
    control.pressButton();
	}
}
