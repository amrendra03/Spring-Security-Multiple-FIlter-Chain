var responseData = "";

function sendData() {
   var username = document.getElementById("username").value;
   var fileInput = document.getElementById("fileInput");
   var file = fileInput.files[0];
   var formData = new FormData();
   formData.append("username", username);
   formData.append("file", file);

   var xhr = new XMLHttpRequest();
   var url = "/processData";
   xhr.open("POST", url);
   xhr.setRequestHeader(csrfHeader, csrfToken);
   xhr.onload = function () {
      if (xhr.status == 200) {
         responseData = xhr.responseText;
         document.getElementById("responseText").innerText = xhr.responseText;
      } else {
         console.error("Request failed. Returned status of " + xhr.status);
      }
   };
   xhr.send(formData);
}

function sendDataToThanks() {
   var xhr = new XMLHttpRequest();
   var url = "/thanks";
   xhr.open("POST", url);
   xhr.setRequestHeader("Content-Type", "application/json");
   xhr.setRequestHeader(csrfHeader, csrfToken);
   xhr.onload = function () {
      if (xhr.status == 200) {
         console.log(xhr.responseText);
      } else {
         console.error("Request failed. Returned status of " + xhr.status);
      }
   };
   xhr.send(JSON.stringify({ responseData: responseData }));
}









