import java.util.Random;
public class Condition {
    protected int mise=1;
    protected boolean condi;
    protected int credit=0,win=0,StopR,StopR2,StopR3;
    public int randInt(int min,int max){
	Random rnd=new Random();
	int rand=rnd.nextInt((max - min)+1)+min;
	return rand;
    }
    public int getCredit(){
	return this.credit;
    }
    public void setCredit(int cr){
	this.credit=cr;
    }

    public int credit(){
	if(condi==true){//le condi pour savoir est ce qu'il a gagner ou pas
	    credit+=getWin();
	    return this.credit;
	}
	credit-=getMise();
	return this.credit;}
    public int condition(){
	if((StopR3==0)){
	    condi=true;//la ou je peut savoir est ce qu'il a gagner
	    if(this.mise==1)
		return this.win=5;
	    else if(this.mise==2)
		return this.win=10;
	    else
		return this.win=15;
	}
	else if((StopR==0)&&(StopR2==0)&&(StopR3==0)){
	    condi=true;
	    if(this.mise==1)
		return this.win=10;
	    else if(this.mise==2)
		return this.win=20;
	    else
		return this.win=30;
	}
	else if((StopR==1)&&(StopR2==1)&&(StopR3==1)){
	    condi=true;
	    if(this.mise==1)
		return this.win=10;
	    else if(this.mise==2)
		return this.win=20;
	    else
		return this.win=30;
	}
	else if((StopR==4)&&(StopR2==4)&&(StopR3==4)){
	    condi=true;
	    if(this.mise==1)
		return this.win=20;
	    else if(this.mise==2)
		return this.win=40;
	    else
		return this.win=60;
	}
	else if((StopR3==3)){
	    condi=true;
	    if(this.mise==1)
		return this.win=25;
	    else if(this.mise==2)
		return this.win=50;
	    else
		return this.win=75;
	}
	else if((StopR==5)&&(StopR2==5)&&(StopR3==5)){
	    condi=true;
	    if(this.mise==1)
		return this.win=30;
	    else if(this.mise==2)
		return this.win=60;
	    else
		return this.win=90;
	}
	else if((StopR==6)&&(StopR2==6)&&(StopR3==6)){
	    condi=true;
	    if(this.mise==1)
		return this.win=100;
	    else if(this.mise==2)
		return this.win=200;
	    else
		return this.win=300;
	}
	else if((StopR==2)&&(StopR2==2)&&(StopR3==2)){
	    condi=true;
	    if(this.mise==1)
		return this.win=2000;
	    else if(this.mise==2)
		return this.win=5000;
	    else
		return this.win=10000;
	}
	condi=false;
	return this.win=0;
    }
    public void setStopR(int c){
	this.StopR=c;
    }
    public void setStopR2(int c){
	this.StopR2=c;
    }
    public void setStopR3(int c){
	this.StopR3=c;
    }
    public int getStopR(){
	return this.StopR;
    }
    public int getStopR2(){
	return this.StopR2;
    }
    public int getStopR3(){
	return this.StopR3;
    }

    public int getWin(){

	return this.win;

    }

    public int Credit(){

	return this.credit;

    }

    public int getMise(){

	return this.mise;

    }

    public void setMise(int m){

	this.mise=m;

    }

    public void random(){

	StopR=randInt(0,6);

	StopR2=randInt(0,6);

	StopR3=randInt(0,6);

    }
}
