package study.inflearn.dp.problem10_03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem10_03_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int[] inputs = Arrays.stream(split[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		int answer = app.solution(inputs);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem10_03_params() {
		return Stream.of(
			of("11\n"
				+ "5 2 18 3 4 7 10 9 11 8 15", 7),
			of("70\n"
					+ "39 68 2 31 3 56 25 58 57 35 63 19 69 22 54 38 41 53 6 32 27 34 17 61 8 36 18 55 26 66 43 24 12 50 30 59 47 46 33 70 4 21 10 44 62 28 65 14 37 15 45 48 7 64 1 49 51 13 23 60 20 40 11 5 67 16 9 29 52 42",
				15),
			of("5\n"
				+ "5 4 3 2 1", 1),
			of("500\n"
					+ "202 180 385 343 35 417 42 116 364 306 397 57 218 370 344 274 206 231 392 429 167 103 228 71 63 382 146 486 65 354 173 478 383 276 66 169 118 442 54 243 31 267 457 324 268 203 156 194 17 440 124 141 443 136 488 434 114 8 98 265 494 296 332 327 469 238 422 322 18 423 69 412 47 421 284 30 455 92 155 84 432 200 337 314 96 313 27 56 201 490 197 53 391 476 326 401 305 472 461 394 140 41 74 221 376 369 448 320 498 233 384 413 212 220 13 367 266 487 428 117 366 317 463 481 264 67 150 210 388 342 193 253 500 282 365 11 263 252 280 398 492 311 308 416 246 211 431 177 113 400 355 496 153 347 351 20 403 73 250 349 154 298 329 145 452 195 39 375 386 290 474 339 283 213 166 187 341 168 295 299 152 182 222 26 460 209 37 402 119 333 208 275 79 260 427 425 278 372 480 61 190 7 58 287 450 132 495 254 447 312 269 126 257 272 353 76 131 359 446 293 241 22 396 34 297 451 183 277 374 105 285 186 196 59 303 160 107 52 256 86 12 389 301 142 199 468 188 315 497 483 438 418 164 363 362 262 111 87 24 323 484 345 32 235 219 46 43 259 50 149 340 78 232 430 473 439 258 288 240 161 172 129 318 286 304 135 99 466 77 224 62 319 175 237 309 348 97 249 458 350 101 207 485 378 247 393 70 335 225 445 456 361 89 477 338 444 273 491 88 229 437 9 449 435 143 381 462 405 184 334 244 60 230 245 158 3 48 330 179 181 29 236 204 395 387 227 426 420 479 191 352 125 148 436 475 83 109 465 51 176 2 380 165 482 128 139 85 404 408 5 223 357 226 93 399 80 464 279 178 94 205 36 234 346 144 185 289 310 336 112 4 147 407 157 171 419 406 45 493 281 321 470 90 122 6 302 331 379 270 368 358 21 16 123 91 108 104 371 411 291 174 19 410 28 255 467 356 44 1 242 271 409 198 49 38 424 499 115 14 25 459 151 102 441 138 373 110 454 360 307 106 40 134 15 81 130 328 415 162 33 300 189 10 248 214 216 23 390 137 489 453 433 294 121 251 215 95 471 82 64 217 377 325 414 100 159 120 239 163 68 170 133 261 72 292 55 316 75 192 127",
				38),
			of("1000\n"
					+ "825 236 669 106 151 537 283 254 405 377 332 877 270 7 249 717 443 413 908 975 520 619 508 242 893 82 934 786 704 1 477 610 600 919 571 751 789 674 824 639 190 536 841 363 227 428 749 185 573 3 653 949 442 855 594 240 859 59 865 326 689 614 452 742 297 943 632 542 298 248 718 446 8 230 677 521 774 892 305 826 575 515 44 901 344 754 56 772 475 253 861 97 90 218 728 130 214 209 201 603 697 369 380 46 256 108 247 261 990 187 188 258 388 195 939 379 735 854 534 606 834 461 812 272 424 375 803 410 491 425 582 368 608 373 169 510 948 675 267 159 351 710 285 541 399 692 844 999 95 148 590 418 851 941 921 69 559 342 199 793 869 483 928 128 339 879 80 402 882 338 886 77 870 690 55 518 833 352 336 487 167 676 158 644 532 415 741 713 828 801 252 656 664 132 117 725 618 976 705 125 615 357 71 480 527 289 453 389 361 560 58 430 848 936 954 217 139 484 925 450 617 878 474 564 951 211 459 35 226 43 498 281 40 370 416 623 626 325 64 712 528 434 502 998 264 133 356 241 85 294 569 444 959 868 220 968 599 170 493 876 234 961 394 628 349 771 79 752 694 523 661 111 822 522 489 136 304 454 103 142 598 39 426 469 929 68 335 965 889 604 262 902 945 29 658 722 678 910 942 624 202 193 83 767 463 421 347 907 935 659 57 99 295 577 36 636 322 738 796 665 890 456 829 168 764 715 711 367 818 319 737 91 953 891 613 695 647 280 397 730 284 186 838 535 758 714 239 666 417 271 447 519 11 153 396 176 686 679 150 16 213 670 54 512 530 782 61 723 552 927 41 327 753 395 845 539 237 184 843 53 21 140 287 938 558 566 260 24 974 847 10 182 122 864 775 556 667 655 207 866 358 646 634 588 784 842 382 355 765 215 259 875 238 997 816 366 514 317 650 49 23 576 144 481 526 173 748 48 19 970 50 719 691 165 505 914 65 30 885 917 781 100 89 952 123 154 457 115 381 401 120 15 346 896 265 642 460 206 804 779 309 33 684 314 468 18 435 721 387 353 911 482 989 110 143 587 109 411 918 203 612 155 593 895 66 219 739 341 554 625 688 320 983 114 811 134 323 621 51 849 720 172 376 808 76 904 640 567 245 52 124 602 757 916 543 538 899 360 654 732 620 850 149 17 255 107 972 333 365 345 204 13 662 545 449 462 420 547 485 268 930 163 244 392 563 37 470 212 966 561 616 557 465 479 92 437 331 867 671 913 300 956 743 769 278 423 533 88 282 823 306 585 471 292 38 652 553 580 900 307 472 805 180 745 372 827 299 86 840 777 441 933 819 500 978 75 501 643 350 574 390 131 313 583 611 897 668 987 205 993 383 785 223 982 909 183 257 973 660 152 251 156 364 946 179 734 290 436 112 591 374 831 931 228 235 28 682 31 189 438 609 790 984 873 303 22 860 291 496 995 94 101 26 683 27 724 915 707 835 568 315 81 20 9 940 776 540 958 980 378 25 422 191 221 5 746 488 562 12 403 605 445 312 944 328 429 531 797 817 607 127 412 969 473 546 2 693 102 348 73 798 657 846 301 288 964 177 302 630 971 709 105 160 198 406 836 516 275 963 432 137 883 641 497 813 887 433 274 216 34 231 250 960 135 337 548 277 246 407 579 478 888 791 286 273 385 126 783 550 400 853 98 408 967 208 706 316 311 872 62 698 996 991 495 586 760 113 119 787 276 70 986 839 716 856 763 663 225 525 4 1000 985 922 792 398 293 957 318 229 511 509 194 266 146 371 162 439 673 104 492 544 84 431 6 232 45 47 451 837 750 513 210 595 506 681 118 622 988 802 458 687 334 321 310 810 419 440 72 455 391 448 175 427 181 880 243 806 386 733 858 821 884 702 74 504 178 161 354 832 601 992 755 768 196 955 731 572 633 171 507 770 800 63 881 565 651 680 696 894 192 807 809 871 464 42 912 138 649 778 857 529 898 490 279 906 141 638 116 701 762 121 414 96 551 708 157 756 145 937 330 362 727 924 820 761 596 740 476 862 815 903 799 200 795 570 629 947 729 549 269 926 780 699 343 874 672 773 592 324 60 726 93 905 222 87 648 340 814 503 409 147 555 863 994 766 744 589 759 359 486 977 467 78 393 920 32 685 794 67 747 404 584 197 736 981 494 830 308 166 578 296 635 129 637 627 645 962 174 233 517 14 631 329 979 384 597 224 923 950 263 499 700 852 524 164 466 788 581 932 703",
				57)
		);
	}
}