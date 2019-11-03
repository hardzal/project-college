#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>
// Set these to run example.
#define FIREBASE_HOST "https://project-sisdig.firebaseio.com/"
#define FIREBASE_AUTH "i69MHzkaMP4NFM1XqWuFW2n4Y4jg5NV59uUg5ERA"

#define PORT 80
 
const char* ssid = "Masjid At-Taqwa";
const char* password = "solatdulu";
const int ledPin = D1;
WiFiServer server(PORT);

void setup() 
{
  Serial.begin(115200);
  delay(10);
 
  pinMode(ledPin, OUTPUT_OPEN_DRAIN);
  digitalWrite(ledPin, HIGH);
 
  // Connect to WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
 
  // Start the server
  server.begin();
  Serial.println("Server started");
 
  // Print the IP address
  Serial.print("Use this URL : ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}
 
void loop() {
  // Check if a client has connected
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
 
  // Wait until the client sends some data
  Serial.println("new client");
  while(!client.available()){
    delay(1);
  }
 
  // Read the first line of the request
  String request = client.readStringUntil('\r');
  Serial.println(request);
  client.flush();
 
  // Match the request
 
  int value = LOW; 
 
  // Return the response
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println(""); //  do not forget this one
  client.println("<!DOCTYPE HTML>");
  client.println("<html>");
  client.print("<center><h1>Led pin is now: ");
  
  if(value==LOW) client.print("OFF</h1>");
  else if(value==HIGH) client.print("ON</h1>");
  
  client.print("Waktu sekarang :<em><script>document.write(new Date());</script></em>");
  
  if (request.indexOf("/LED=ON") != -1) 
  {
    digitalWrite(ledPin, 0);
    value = HIGH;
    Serial.println("nyala");
  }
  if (request.indexOf("/LED=OFF") != -1)
  {
    digitalWrite(ledPin, 1);
    value = LOW;
    Serial.println("mati");
  }
  
  client.println("<br><br>");
  client.println("<h2>Click <strong><a href=\"/LED=ON\" style='border-radius: 10px;background-color: green; color: white; padding: 0px 5px 5px 5px; text-decoration: none;'>here</a></strong> Turn relay ON<br></h2>");
  client.println("<h2>Click <strong><a href=\"/LED=OFF\" style='border-radius: 10px;background-color: red; color: white; padding: 0px 5px 5px 5px; text-decoration: none;'>here</a></strong> Turn relay OFF<br></h2>");
  client.println("</center></html>");    
 
  delay(1);
  Serial.println("Client disconnected");
  Serial.println(""); 
}
