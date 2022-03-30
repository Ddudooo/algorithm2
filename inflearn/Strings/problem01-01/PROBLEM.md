<div data-v-4b3ae1dc="" class="ivu-card ivu-card-dis-hover ivu-card-shadow"><div class="ivu-card-head"><div class="panel-title"><div data-v-4b3ae1dc="">1. 문자 찾기</div></div></div> <div class="ivu-card-extra"><div class="panel-extra"></div></div> <div class="ivu-card-body" style="padding: 40px;">  <div class="panel-body"> <div data-v-4b3ae1dc="" id="problem-content" class="markdown-body"><p data-v-4b3ae1dc="" class="title">설명</p> <p data-v-4b3ae1dc="" class="content"><p>한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.</p><p>대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.</p></p> <p data-v-4b3ae1dc="" class="title">입력 <!----></p> <p data-v-4b3ae1dc="" class="content"><p>첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.</p><p>문자열은 영어 알파벳으로만 구성되어 있습니다.</p></p> <p data-v-4b3ae1dc="" class="title">출력 <!----></p> <p data-v-4b3ae1dc="" class="content"><p>첫 줄에 해당 문자의 개수를 출력한다.<br></p></p>  <div data-v-4b3ae1dc=""><div data-v-4b3ae1dc="" class="flex-container sample"><div data-v-4b3ae1dc="" class="sample-input"><p data-v-4b3ae1dc="" class="title">예시 입력 1
                  <a data-v-4b3ae1dc="" class="copy"><i data-v-4b3ae1dc="" class="ivu-icon ivu-icon-clipboard"></i></a></p> <pre data-v-4b3ae1dc="">Computercooler
c
</pre></div> <div data-v-4b3ae1dc="" class="sample-output"><p data-v-4b3ae1dc="" class="title">예시 출력 1</p> <pre data-v-4b3ae1dc="">2</pre></div></div></div> <!----> <!----></div></div></div></div>


---

### Sample

```java
import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int input1 = in.nextInt();
    int input2 = in.nextInt();
    System.out.println(input1 + input2);
    return ;
  }
}
```