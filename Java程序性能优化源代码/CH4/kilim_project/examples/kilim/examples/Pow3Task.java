/* Copyright (c) 2006, Sriram Srinivasan
 *
 * You may distribute this software under the terms of the license 
 * specified in the file "License"
 */

package kilim.examples;


import java.util.ArrayList;

import kilim.ExitMsg;
import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

public class Pow3Task extends Task {
    static int CIRCLE=10000;					//�������͵ķ�Χ
    static int TASK_NUM=10000;
    
    static Mailbox<Integer> mb = new Mailbox<Integer>(CIRCLE,CIRCLE);
    static Mailbox<Integer> result = new Mailbox<Integer>();
    static Mailbox<ExitMsg> exitBox = new Mailbox<ExitMsg>();

    int type=0;
    int re=0;
   
    public Pow3Task(int type){
    	this.type=type;
    }
    
    public static void main(String[] args) throws Exception {
    	long beginTime=System.currentTimeMillis();
    	ArrayList<Task> tasks=new ArrayList<Task>();
    	for(int i=0;i<CIRCLE;i++){				//������Ϣ
    		mb.putnb(i);
    	}
    	for(int i=0;i<TASK_NUM;i++){
    		new Pow3Task(0).start();			//����������Э��
    	}
    	Task t = new Pow3Task(1).start();		//�������Э��
    	t.informOnExit(exitBox);
    	exitBox.getb();
    	long endtime=System.currentTimeMillis();
    	System.out.println("spend time:"+(endtime-beginTime));
        System.exit(0);
    }
  
    public void execute() throws Pausable{
    	if(type==0){
    		Integer s=null;
    		while(true){
    			s = mb.getnb();				//����������Ϊ�����Ѿ�����Ϣ��������
    			if(s==null)break;			//��������ִ����ɣ��˳�
		        result.putb(s*s*s);			//���ؽ��
    		}
    	}else if(type==1){
    		for(int i=0;i<CIRCLE;i++)
    			re+=result.get();			//����ۼ�
    		System.out.println("re="+re);
    	}
    }
}
