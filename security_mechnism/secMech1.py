import py7zr
import os


f=open("password.dat","rb")
newPassword = f.readline()
f.close()

#Encrypting
'''with py7zr.SevenZipFile('target.7z', mode='r', password='') as z:
    z.extractall()
'''
#De-Encrypting
with py7zr.SevenZipFile('android.7z', 'w', password = newPassword[0]) as archive:
    archive.writeall('Test', 'ErrorBox-App')

#Removing the file 
'''dir_path = "ErrorBox-App"

try:
    os.remove(dir_path)
except OSError as e:
    print("Error: %s : %s" % (dir_path, e.strerror))'''


