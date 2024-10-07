
CMPE-277 – Assignment 1:


Activity Lifecycle
In this application, We have incremented the thread counter whenever the Main Activity restarts to demonstrate that when a new activity (Activity B, Activity C) is opened and we go back to the previous activity, onRestart() method is called. We increment the thread counter by 5.
On the other hand, when a dialog Activity is opened, and we go back to the previous activity, onRestart() method is not called, so the thread counter remains unchanged.
Home screen:


<img width="1440" alt="Screenshot 2024-10-06 at 10 06 52 PM" src="https://github.com/user-attachments/assets/af08b06f-14ba-4d2f-8b6e-987c56006f96">





Activity B opened:

<img width="1440" alt="Screenshot 2024-10-06 at 10 06 56 PM" src="https://github.com/user-attachments/assets/039e494a-8df4-4f63-a81b-7a948f2c8762">





Count incremented by 5:
<img width="1440" alt="Screenshot 2024-10-06 at 10 06 59 PM" src="https://github.com/user-attachments/assets/815db9f1-3f92-4bc6-b7e4-473b446576cb">


Dialog opened:
<img width="1440" alt="Screenshot 2024-10-06 at 10 07 02 PM" src="https://github.com/user-attachments/assets/fb7d7fce-9a94-443d-8a66-4d43f3a471a7">


Close app:
<img width="1440" alt="Screenshot 2024-10-06 at 10 07 09 PM" src="https://github.com/user-attachments/assets/3420e9de-a82f-4b59-a6cc-d0f6c4be4147">




