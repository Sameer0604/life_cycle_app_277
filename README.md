
CMPE-277 – Assignment 1:


Activity Lifecycle
In this application, We have incremented the thread counter whenever the Main Activity restarts to demonstrate that when a new activity (Activity B, Activity C) is opened and we go back to the previous activity, onRestart() method is called. We increment the thread counter by 5.
On the other hand, when a dialog Activity is opened, and we go back to the previous activity, onRestart() method is not called, so the thread counter remains unchanged.
Home screen:

<img width="1440" alt="Screenshot 2024-10-06 at 10 32 04 PM" src="https://github.com/user-attachments/assets/1147a839-5700-494d-ac40-25da250c767e">





Activity B opened:

<img width="1440" alt="Screenshot 2024-10-06 at 10 32 30 PM" src="https://github.com/user-attachments/assets/3baf784e-bba6-407d-85c7-153189f3c340">





Count incremented by 5:
<img width="1440" alt="Screenshot 2024-10-06 at 10 32 37 PM" src="https://github.com/user-attachments/assets/964e6313-6448-4dc1-9de8-81d6b4b0d372">



Dialog opened:
<img width="1440" alt="Screenshot 2024-10-06 at 10 32 43 PM" src="https://github.com/user-attachments/assets/12c02ff0-4402-44df-88f2-357ccb6ffbec">


Close app:

<img width="1440" alt="Screenshot 2024-10-06 at 10 32 50 PM" src="https://github.com/user-attachments/assets/bea76ffe-8643-4883-9ab0-8ee0763bf44a">



