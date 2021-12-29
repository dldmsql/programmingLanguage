let
    int avg = 0; int sum = 0; int n;
in
    print "please write number you want to calculate and enter the enter key";
    read n;
    for(int j = 0; j< n; j=j+1;){
        sum = sum + j;
    }
    avg = sum/n;
    print avg;
end;
