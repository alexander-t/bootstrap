It's more convenient if NModel is in the path:

set PATH=%PATH%;"D:\Program Files (x86)\NModel\bin"

To examine the model using MPV:

mpv /r:NModel\bin\Debug\NModel.dll ModelTest.TimerModel.Create

To create a test case file with offline tests:

otg /r:NModel\bin\Debug\NModel.dll ModelTest.TimerModel.Create /file:TimerTest.txt

To run the "test":

ct /r:NModel\bin\Debug\NModel.dll /iut:ModelTest.TimerStepper.Create /testSuite:TimerTest.txt