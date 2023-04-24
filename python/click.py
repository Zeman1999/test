# 改进版
import pyautogui as pag
from time import sleep,time
import pyautogui as ui


pag.PAUSE = 0
def mouse():
#    b = input('请问您需要点击多少下？')
    b = int(1)
#   c = input('点击时需要左键还是右键？\n左键请输入0，右键输入1：')
    c = int(0)
#    print('请注意：您需要在8秒内将鼠标移动到您需要连点的地方，然后不要动，等待开始快速连点。')
#    t = input("要循环几次？")
    o = int(10)
    sleep(2)
    print('开始点击！')
    x,y = pag.position()
    d = 'left'
    if c:
        d = 'right'
    e = time()
#    for i in range(0,b):
#        pag.click(x,y,button = d)
    p = 0
    while p < o:
        for i in range(0,b):
            pag.click(1742,465,button = d)
        f = time() - e
        sleep(0.5)
        for i in range(0,b):
            pag.click(1772,411,button = d)
        f = time() - e
        sleep(0.5)
        p += 1
    input('完成。用时%f秒。' % f)
    
def key():
    print('请在以下支持的按键中挑选您需要的键。')
    for i in pag.KEYBOARD_KEYS:
        print(r'%s' % i,end=' ')
    b = input('\n请输入您需要快速输入的字符：')
    if b in pag.KEYBOARD_KEYS:
        c = input('请输入您需要多少次输入：')
        c = int(c)
        print('请注意，您需要在8秒内切换到需要输入的窗口。')
        sleep(8)
        print('开始工作！')
        e = time()
        for i in range(0,c):
            pag.press(b)
        f = time() - e
        input('完成。用时%f秒。' % f)
    else:
        input('您输入的字符不属于支持字符，请修改。')    
    
try:
 #   a = input('输入您需要的服务（数字）：\n1:快速连点\n2:快速输入\n>>> ')
    a = int(1)
    if a == 1:
        mouse()
    elif a == 2:
        key()
    else:
        input('不好意思，没有找到您需要的服务。\n')
except Exception as e:
    print('错误；\n',e)
