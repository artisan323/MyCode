package javatuning.ch2.observor;

public interface ISubject{  
    void attach(IObserver observer);	//��ӹ۲���  
    void detach(IObserver observer);	//ɾ���۲���  
    void inform();					//֪ͨ���й۲���  
}  
