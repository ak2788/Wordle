# Android Project 1 - Wordle

Submitted by: Afsheen Khan

**Wordle** is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: **8** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **User has 3 chances to guess a random 4 letter word**
- [x] **After 3 guesses, user should no longer be able to submit another guess**
- [x] **After each guess, user sees the "correctness" of the guess**
- [x] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle between different word lists
- [x] User can see the 'correctness' of their guess through colors on the word 
- [ ] User sees a visual change after guessing the correct word
- [x] User can tap a 'Reset' button to get a new word and clear previous guesses
- [x] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [x] Keyboard is automatically hidden after the user hits the guess button to improve UI.
## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/user-attachments/assets/a2bcf8e3-6d11-4537-b9e6-2bfd8e6fd841' title='Video Walkthrough' width='30%' height='auto' alt='Video Walkthrough' />


<!-- Replace this with whatever GIF tool you used! -->
GIF created with Canva  
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

Spannable was difficult to work with because initially, the colors were not showing up even though the logic and Spannable code were correct. I had to explicitly use the setText() function and force the TextView to treat the Spannable string as styled text. My only other concern is that this project took more time than I was expecting.

## License

    Copyright [2026] [Afsheen Khan]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
