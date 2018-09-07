#include<iostream>
#include <string> 

using namespace std;


int process(string input) {
	int result = 0, balancer = 0;
	for(int i = 0; i < input.length(); i++) {
		char c = input.at(i);
		if(c == '{') {
			balancer++;
		} else {
			balancer--;	
		}
		if(balancer < 0) {
			balancer += 2;
			result++;
		}
		if(balancer >= input.length() - i) {
			balancer -= 2;
			result++;
		}
	}
	return result;
}

int main() {
	int i = 1;
	string s;
	freopen("input.txt", "r", stdin);
	while (getline(cin, s)) {	
		if(s.at(0) == '-') break;
		printf("%d. %d\n", i++, process(s));
	}
	return 0;
}
