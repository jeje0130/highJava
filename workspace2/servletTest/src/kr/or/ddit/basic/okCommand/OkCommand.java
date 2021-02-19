package kr.or.ddit.basic.okCommand;

public class OkCommand {
	private ICommand command;

	//생성자
	public OkCommand(ICommand command) {
		this.command = command;
	}

	//setter
	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	public void run() {
		command.execute();
	}
	
	
	
}
