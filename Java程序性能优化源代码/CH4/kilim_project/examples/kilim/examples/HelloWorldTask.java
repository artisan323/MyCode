/* Copyright (c) 2006, Sriram Srinivasan
 *
 * You may distribute this software under the terms of the license 
 * specified in the file "License"
 */

package kilim.examples;

import kilim.ExitMsg;
import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

public class HelloWorldTask extends Task {
    static Mailbox<String> mb = new Mailbox<String>();
    static Mailbox<ExitMsg> exitmb = new Mailbox<ExitMsg>();		
    int type=0;							//Task���������֣�0��ʾ�����ߣ�1��ʾ������
    public HelloWorldTask(int type){
    	this.type=type;
    }
    
    public static void main(String[] args) throws Exception {
        Task sender = new HelloWorldTask(1).start();
        Task reciever = new HelloWorldTask(0).start();
        reciever.informOnExit(exitmb);	//Ҫ��������ڽ�������д�˳�����
        exitmb.getb();					//�˳����������ݣ���ʾ�������Ѿ�����
        System.exit(0);			
    }
    
    public void execute() throws Pausable{
    	if(type==0){					//������	
	        while (true) {
	            String s = mb.get();
	            if (s.equals("over")) 
	            	break;
	            System.out.print(s);
	        }
    	}else if(type==1){				//������
            mb.putnb("Hello ");
            mb.putnb("World\n");
            mb.putnb("over");
    	}
    }
}
