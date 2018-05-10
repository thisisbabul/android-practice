#include <SoftwareSerial.h>
SoftwareSerial BT(10, 11); //TX, RX  pins of arduino respetively
String command;
int doorOpen = 2, doorClose = 3, light = 4, fan = 5;
int smokeA0 = A5;
int sensorThres = 300;

void setup()
{
  pinMode(smokeA0, INPUT);
  
  BT.begin(9600);
  Serial.begin(9600);
  pinMode(doorOpen, OUTPUT);
  pinMode(doorClose, OUTPUT);
  pinMode(light, OUTPUT);
  pinMode(fan, OUTPUT);

  

}

void loop() {
  int analogSensor = analogRead(smokeA0);
  if (analogSensor > sensorThres){
      digitalWrite (light, LOW);
      digitalWrite (fan, LOW);
    }
  while (BT.available()){  //Check if there is an available byte to read
  delay(10); //Delay added to make thing stable
  char c = BT.read(); //Conduct a serial read
  command += c; //build the string.
  } 
  if (command.length() > 0) {
    Serial.println(command);
  if(command == "DoorOpen") //this command will be given as an input to switch on light1
  {
    digitalWrite(doorOpen,HIGH); //Motor runs clockwise// 
    delay(2000);            //for 1 second// 
    digitalWrite(doorOpen, LOW); //Motor stops//
    
  }
  else if (command == "DoorClose")
  {
    //digitalWrite (doorClose, HIGH);
    digitalWrite(doorClose, HIGH);//Motor runs counter-clockwise// 
    delay(2000);            //For 1 second//
    digitalWrite(doorClose, LOW); //Motor stops// 
  }
  else if ( command == "LightOn" && analogSensor < sensorThres)
 {
   digitalWrite (light, HIGH);
 }
  else if (command == "LightOff")
 {
   digitalWrite (light, LOW);
 }
  else if (command == "FanOn" && analogSensor < sensorThres)
 {
   digitalWrite (fan, HIGH);
 }
  else if (command == "FanOff") //using this command you can switch on all devices
 {
   digitalWrite (fan, LOW);
 }
command="";}}
