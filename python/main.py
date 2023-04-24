import time
import pyautogui
import keyboard

a=int(input("点击次数:"))
b=float(input("点击间隔/s:"))
c=float(input("请输入您将鼠标移动至指定位置所需的时间:"))
while c>=0:
    print(c,"s内将鼠标移动至指定位置")
    time.sleep(1)
    c-=1
z=pyautogui.position()

print("开始运行")
print("点击esc可以退出")

while a>0:
    pyautogui.click(z[0],z[1])
    a-=1
    time.sleep(b)
    if keyboard.is_pressed('esc'):
        break