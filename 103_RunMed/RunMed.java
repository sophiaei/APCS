// National Security Agency: Nora Miller, Sophia Eiden, Ameer Alnasser
// APCS pd6
// HW103 -- Erica's Friends, Hugo, and The One in the Middle
// 2022-05-18w
// time spent: 1 hrs

/*
ALGO:
we add to lilVals first, then to bigVals. then, if the newVal is less than lilVals, it gets added to the heap. if the new
val is greater than bigVals, it gets added to the other heap. if the sizes are off
by more than one, remove the extreme and add it to the other heap
DISCO:
Median should be a double

QCC:
why use heaps in the first place? especially considering storing and updating three vals (median, value above, value below)
would suffice?
Why do we not just assign the median to a variable and treat it as an invariant?
*/
public class RunMed{
  ALHeapMin bigVals;
  ALHeapMax lilVals;
  public RunMed(){
    bigVals= new ALHeapMin();
    lilVals= new ALHeapMax();
  }
  public Integer add(Integer newVal){

    if(lilVals.size()==0){
      lilVals.add(newVal);
    }
    else if(bigVals.size()==0){
      bigVals.add(newVal);
    }
    if(newVal>=bigVals.peekMin()){
      bigVals.add(newVal);
    }
    else if(newVal<=lilVals.peekMax()){
      lilVals.add(newVal);
    }
    while(Math.abs(lilVals.size()-bigVals.size())>1){
    if(lilVals.size()-bigVals.size()>1){
      int x= lilVals.peekMax();
      lilVals.removeMax();
      bigVals.add(x);
    }
    else if(bigVals.size()-lilVals.size()>1){
          int x= bigVals.peekMin();
          bigVals.removeMin();
          lilVals.add(x);
        }
}
return newVal;

}
  public double getMedian(){
    if((bigVals.size()+lilVals.size())%2==0){
      return (double)(bigVals.peekMin() + lilVals.peekMax())/2;
    }
    return (double)lilVals.peekMax();
  }

}
