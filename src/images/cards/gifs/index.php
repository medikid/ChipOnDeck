<html>
<head>

</head>
<body>
<script language="Javascript">

Player_1 = new Array();
Player_2 = new Array();
table = new Array();
hands = new Array();
hands[0] ="Royal flush";
hands[1] ="Straight flush";
hands[2] ="Four of a kind";
hands[3] ="Full house";
hands[4] ="flush";
hands[5] ="Straight";
hands[6] ="Three of a kind";
hands[7] ="Two pair";
hands[8] ="One pair";
hands[9] ="High card";

var Deck = new Array();
Deck[0]="SA" ;Deck[13]="LA" ;Deck[26]="HA" ;Deck[39]="RA"; // A
Deck[1]="SK" ;Deck[14]="LK" ;Deck[27]="HK" ;Deck[40]="RK"; // king
Deck[2]="SQ" ;Deck[15]="LQ" ;Deck[28]="HQ" ;Deck[41]="RQ"; // queen
Deck[3]="SJ" ;Deck[16]="LJ" ;Deck[29]="HJ" ;Deck[42]="RJ"; // jack
Deck[4]="S0" ;Deck[17]="L0" ;Deck[30]="H0" ;Deck[43]="R0"; // 10
Deck[5]="S9" ;Deck[18]="L9" ;Deck[31]="H9" ;Deck[44]="R9"; // 9
Deck[6]="S8" ;Deck[19]="L8" ;Deck[32]="H8" ;Deck[45]="R8"; // 8
Deck[7]="S7" ;Deck[20]="L7" ;Deck[33]="H7" ;Deck[46]="R7"; // 7
Deck[8]="S6" ;Deck[21]="L6" ;Deck[34]="H6" ;Deck[47]="R6"; // 6
Deck[9]="S5" ;Deck[22]="L5" ;Deck[35]="H5" ;Deck[48]="R5"; // 5
Deck[10]="S4" ;Deck[23]="L4" ;Deck[36]="H4" ;Deck[49]="R4"; // 4
Deck[11]="S3" ;Deck[24]="L3" ;Deck[37]="H3" ;Deck[50]="R3"; // 3
Deck[12]="S2" ;Deck[25]="L2" ;Deck[38]="H2" ;Deck[51]="R2"; // 2
//Schoppen klaveren harten ruiten
var CurDeck = new Array()
CurDeck=Deck;

//shuffles
function Shuffle ( myArray ) {
var i = myArray.length;
if ( i == 0 ) return false;
while ( --i ) {
var j = Math.floor( Math.random() * ( i + 1 ) );
var tempi = myArray[i];
var tempj = myArray[j];
myArray[i] = tempj;
myArray[j] = tempi;
}


}
Shuffle(CurDeck);
Player_1[0]=CurDeck[10];
Player_1[1]=CurDeck[11];
Player_2[0]=CurDeck[12];
Player_2[1]=CurDeck[13];
table[0] =CurDeck[14];
table[1] =CurDeck[15];
table[2] =CurDeck[16];
table[3] =CurDeck[17];
table[4] =CurDeck[18];

function checkHand(player)
{
var possibleHands = new Array();
Card1=Player_1[0]; // this was "Card1=player[0];" at first, but debugger said that was incorrect.
Card2=Player_1[1]; //
Card3=table[0];
Card4=table[1];
Card5=table[2];
Card6=table[3];
Card7=table[4];
/*get all possible hands, I know it would been easier to assign them manually, but I like to go the hard way when practising :P*/
for (i=1;i<=10;i++)
{
possibleHands[i] = new Array();
possibleHands[i][0]=Card1;
possibleHands[i][1]=Card2;
if (i<=6)
{
possibleHands[i][2]=Card3;
if (i<=3)
{
possibleHands[i][3]=Card4;
if (i==1){possibleHands[i][4]=Card5;}
if (i==2){possibleHands[i][4]=Card6;}
if (i==3){possibleHands[i][4]=Card7;}
}
else
if (i<=2)
{
possibleHands[i][3]=Card5;
if(i<=1)
{
possibleHands[i][4]=Card6;
}
else
{
possibleHands[i][4]=Card7;
}
}
else
{
if (i==3){possibleHands[i][3]=Card6;possibleHands[i][4]=Card7;}
if (i==4){possibleHands[i][3]=Card6;possibleHands[i][4]=Card5;}
if (i==5){possibleHands[i][3]=Card7;possibleHands[i][4]=Card5;}
}
}
else
{
if (i<=9)
{
possibleHands[i][2]=Card4;
if (i<=8)
{
possibleHands[i][3]=Card5;
if (i<=7)
{
possibleHands[i][4]=Card6;
}
else
{
possibleHands[i][4]=Card7;
}
}
else
{
possibleHands[i][3]=Card6;
possibleHands[i][4]=Card7;
}
}
else
{
possibleHands[i][2]=Card5;
possibleHands[i][3]=Card6;
possibleHands[i][4]=Card7;
}
}
}
for (i=1;i<=10;i++)
{
document.write("Case: "+i+"<br />");
document.write(possibleHands[i][0]+"<br />");
document.write(possibleHands[i][1]+"<br />");
document.write(possibleHands[i][2]+"<br />");
document.write(possibleHands[i][3]+"<br />");
document.write(possibleHands[i][4]+"<br />");

}
}
//test

checkHand('Player_1');

</script>
</body>
</html> 